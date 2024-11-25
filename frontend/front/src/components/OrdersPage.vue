<template>
    <div class="orders-container">
      <h1>Orders</h1>
      <div v-if="orders.length">
        <div v-for="order in orders" :key="order.id" class="order">
          <h2>Order #{{ order.id }} ({{ order.status }})</h2>
          <p>Total: ${{ order.total }}</p>
          <p>Created at: {{ order.createdAt }}</p>
          <h3>Items:</h3>
          <ul>
            <li v-for="item in order.orderItems" :key="item.productId">
              Product ID: {{ item.productId }}, Quantity: {{ item.quantity }}, Price: ${{ item.price }}
            </li>
          </ul>
        </div>
      </div>
      <div v-else>
        <p>No orders found for this user.</p>
      </div>
    </div>
  </template>
  
  <script>
  import axios from 'axios';
  
  export default {
    name: 'OrdersPage',
    data() {
      return {
        orders: []
      };
    },
    async created() {
      try {
        const userId = localStorage.getItem('userId'); // Recupera el userId del localStorage
        console.log(userId);
        if (userId) {
          const response = await axios.get(`http://localhost:8090/orders/${userId}`);
          this.orders = response.data;
        } else {
          console.error('User ID not found in localStorage');
        }
      } catch (error) {
        console.error('Error fetching orders:', error);
      }
    }
  };
  </script>
  
  <style scoped>
  .orders-container {
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
  
  .order {
    margin-bottom: 20px;
    padding: 10px;
    border: 1px solid #ddd;
    border-radius: 5px;
  }
  
  .order h2 {
    margin: 0 0 10px;
  }
  
  .order ul {
    list-style-type: none;
    padding: 0;
  }
  
  .order li {
    margin: 5px 0;
  }
  </style>
  