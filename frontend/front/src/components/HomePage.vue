<!-- src/components/HomePage.vue -->
<template>
  <div class="home-container">
    <header class="header">
      <h1>Welcome to Our Store</h1>
      <nav class="navbar">
        <router-link to="/products">Products</router-link>
        <router-link to="/orders">Orders</router-link>
        <router-link to="/payments">Payments</router-link>
        <router-link to="/users">Users</router-link>
      </nav>
    </header>
    <section class="hero">
      <h2>Discover Our Amazing Products</h2>
      <p>Explore a variety of items that you will love.</p>
      <router-link to="/products" class="btn">Shop Now</router-link>
    </section>
    <footer class="footer">
      <p>&copy; 2024 Your Store. All rights reserved.</p>
    </footer>
  </div>
</template>

<script>
export default {
  name: 'HomePage',
};
</script>

<style scoped>
.home-container {
  display: flex;
  flex-direction: column;
  min-height: 100vh;
}

.header {
  background-color: #42b983;
  color: white;
  padding: 20px;
  text-align: center;
}

.navbar {
  margin: 10px 0;
}

.navbar a {
  color: white;
  margin: 0 15px;
  text-decoration: none;
  font-weight: bold;
}

.navbar a:hover {
  text-decoration: underline;
}

.hero {
  flex: 1;
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;
  background: url('https://via.placeholder.com/1920x1080') no-repeat center center/cover;
  color: white;
  text-align: center;
  padding: 50px 20px;
}

.hero h2 {
  font-size: 3em;
  margin-bottom: 20px;
}

.hero p {
  font-size: 1.5em;
  margin-bottom: 30px;
}

.hero .btn {
  background-color: #42b983;
  color: white;
  padding: 10px 20px;
  text-decoration: none;
  font-size: 1.2em;
  border-radius: 5px;
}

.hero .btn:hover {
  background-color: #369f73;
}

.footer {
  background-color: #333;
  color: white;
  text-align: center;
  padding: 10px 0;
}
</style>
