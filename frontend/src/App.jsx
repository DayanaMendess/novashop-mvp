import { useEffect, useMemo, useState } from 'react'

const API_URL = import.meta.env.VITE_API_URL || 'http://localhost:8080/api'

export default function App() {
  const [products, setProducts] = useState([])
  const [categories, setCategories] = useState([])
  const [selectedCategory, setSelectedCategory] = useState('all')
  const [cart, setCart] = useState([])
  const [message, setMessage] = useState('')
  const [customer, setCustomer] = useState({
    fullName: 'Sofía Perafán',
    email: 'sofia@novashop.com',
    phone: '3001234567'
  })

  useEffect(() => {
    loadInitialData()
  }, [])

  async function loadInitialData() {
    try {
      const [productsRes, categoriesRes] = await Promise.all([
        fetch(`${API_URL}/products`),
        fetch(`${API_URL}/categories`)
      ])
      const productsData = await productsRes.json()
      const categoriesData = await categoriesRes.json()
      setProducts(productsData)
      setCategories(categoriesData)
    } catch (error) {
      setMessage('No se pudo conectar al backend. Revisa si está corriendo.')
    }
  }

  const filteredProducts = useMemo(() => {
    if (selectedCategory === 'all') return products
    return products.filter(item => item.category?.id === Number(selectedCategory))
  }, [products, selectedCategory])

  function addToCart(product) {
    setCart(prev => {
      const existing = prev.find(item => item.id === product.id)
      if (existing) {
        return prev.map(item =>
          item.id === product.id
            ? { ...item, quantity: item.quantity + 1 }
            : item
        )
      }
      return [...prev, { ...product, quantity: 1 }]
    })
    setMessage(`Agregaste "${product.name}" al carrito`)
  }

  function removeFromCart(id) {
    setCart(prev => prev.filter(item => item.id !== id))
  }

  function changeQty(id, type) {
    setCart(prev =>
      prev
        .map(item => {
          if (item.id !== id) return item
          const quantity = type === 'plus' ? item.quantity + 1 : item.quantity - 1
          return { ...item, quantity }
        })
        .filter(item => item.quantity > 0)
    )
  }

  const total = useMemo(
    () => cart.reduce((acc, item) => acc + Number(item.price) * item.quantity, 0),
    [cart]
  )

  async function simulateCheckout() {
    if (!cart.length) {
      setMessage('Primero agrega productos al carrito.')
      return
    }

    try {
      const customerResponse = await fetch(`${API_URL}/customers`, {
        method: 'POST',
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify(customer)
      })

      let savedCustomer
      if (customerResponse.ok) {
        savedCustomer = await customerResponse.json()
      } else {
        const customersRes = await fetch(`${API_URL}/customers`)
        const allCustomers = await customersRes.json()
        savedCustomer = allCustomers.find(c => c.email === customer.email) || allCustomers[0]
      }

      const cartResponse = await fetch(`${API_URL}/carts`, {
        method: 'POST',
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify({ customerId: savedCustomer.id })
      })
      const createdCart = await cartResponse.json()

      for (const item of cart) {
        await fetch(`${API_URL}/carts/${createdCart.id}/items`, {
          method: 'POST',
          headers: { 'Content-Type': 'application/json' },
          body: JSON.stringify({ productId: item.id, quantity: item.quantity })
        })
      }

      const orderResponse = await fetch(`${API_URL}/orders/checkout/${createdCart.id}`, {
        method: 'POST'
      })
      const order = await orderResponse.json()

      if (order?.id) {
        setMessage(`Pedido #${order.id} creado correctamente. Total: $${Number(order.total).toLocaleString('es-CO')}`)
        setCart([])
        loadInitialData()
      } else {
        setMessage('Se creó el carrito, pero hubo un problema al confirmar el pedido.')
      }
    } catch (error) {
      setMessage('Ocurrió un error al confirmar la compra.')
    }
  }

  return (
    <div className="page">
      <header className="hero">
        <div className="hero__text">
          <span className="pill">MVP académico listo para GitHub</span>
          <h1>NovaShop</h1>
          <p>
            Un carrito de compras con diseño limpio, catálogo visual y flujo de compra básico,
            pensado para que se vea más profesional y diferente al ejemplo original.
          </p>
        </div>
        <div className="hero__card">
          <h3>Resumen</h3>
          <p>Frontend diferente</p>
          <p>Backend con Spring Boot</p>
          <p>PostgreSQL + Docker</p>
          <p>Documentación incluida</p>
        </div>
      </header>

      <main className="layout">
        <section className="catalog">
          <div className="section-title">
            <h2>Catálogo</h2>
            <select value={selectedCategory} onChange={e => setSelectedCategory(e.target.value)}>
              <option value="all">Todas las categorías</option>
              {categories.map(category => (
                <option key={category.id} value={category.id}>
                  {category.name}
                </option>
              ))}
            </select>
          </div>

          <div className="grid">
            {filteredProducts.map(product => (
              <article key={product.id} className="card">
                <img src={product.imageUrl} alt={product.name} />
                <div className="card__content">
                  <small>{product.category?.name || 'Sin categoría'}</small>
                  <h3>{product.name}</h3>
                  <p>{product.description}</p>
                  <strong>${Number(product.price).toLocaleString('es-CO')}</strong>
                  <button onClick={() => addToCart(product)}>Agregar al carrito</button>
                </div>
              </article>
            ))}
          </div>
        </section>

        <aside className="sidebar">
          <div className="cart-box">
            <h2>Tu carrito</h2>
            {cart.length === 0 ? (
              <p className="empty">Aún no has agregado productos.</p>
            ) : (
              <div className="cart-list">
                {cart.map(item => (
                  <div key={item.id} className="cart-item">
                    <div>
                      <h4>{item.name}</h4>
                      <span>${Number(item.price).toLocaleString('es-CO')}</span>
                    </div>
                    <div className="qty">
                      <button onClick={() => changeQty(item.id, 'minus')}>-</button>
                      <span>{item.quantity}</span>
                      <button onClick={() => changeQty(item.id, 'plus')}>+</button>
                    </div>
                    <button className="remove" onClick={() => removeFromCart(item.id)}>Quitar</button>
                  </div>
                ))}
              </div>
            )}

            <div className="checkout-form">
              <h3>Datos del cliente</h3>
              <input
                value={customer.fullName}
                onChange={e => setCustomer({ ...customer, fullName: e.target.value })}
                placeholder="Nombre completo"
              />
              <input
                value={customer.email}
                onChange={e => setCustomer({ ...customer, email: e.target.value })}
                placeholder="Correo"
              />
              <input
                value={customer.phone}
                onChange={e => setCustomer({ ...customer, phone: e.target.value })}
                placeholder="Teléfono"
              />
            </div>

            <div className="total">
              <span>Total</span>
              <strong>${total.toLocaleString('es-CO')}</strong>
            </div>

            <button className="checkout" onClick={simulateCheckout}>
              Confirmar compra
            </button>

            {message && <p className="message">{message}</p>}
          </div>
        </aside>
      </main>
    </div>
  )
}
