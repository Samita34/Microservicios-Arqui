<template>
    <div class="products-container">
      <h1>Products</h1>
      <div v-if="products.length">
        <div v-for="product in products" :key="product.id" class="product">
          <h2>{{ product.name }}</h2>
          <p>{{ product.description }}</p>
          <p>Price: ${{ product.price }}</p>
          <p>Stock: {{ product.stock }}</p>
          <p>Created at: {{ product.createdAt }}</p>
        </div>
      </div>
      <div v-else>
        <p>No products found.</p>
      </div>
    </div>
  </template>
  
  <script>
  import axios from 'axios';
  
  export default {
    name: 'ProductsPage',
    data() {
      return {
        products: []
      };
    },
    async created() {
      try {
        const response = await axios.get(`http://localhost:8090/products`);
        this.products = response.data;
      } catch (error) {
        console.error('Error fetching products:', error);
      }
    }
  };
  </script>
  
  <style scoped>
  .products-container {
    max-width: 800px;
    margin: 0 auto;
    padding: 20px;
    border: 1px solid #ccc;
    border-radius: 10px;
    box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
  }
  
  h1 {
    text-align: center;
  }
  
  .product {
    margin-bottom: 20px;
    padding: 10px;
    border: 1px solid #ddd;
    border-radius: 5px;
  }
  
  .product h2 {
    margin: 0 0 10px;
  }
  
  .product p {
    margin: 5px 0;
  }
  </style>
  