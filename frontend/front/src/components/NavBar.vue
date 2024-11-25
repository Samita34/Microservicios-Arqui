<template>
    <nav>
      <ul>
        <li><router-link to="/login">Home</router-link></li>
        <li><router-link to="/products">Products</router-link></li>
        <li><router-link to="/orders">Orders</router-link></li>
        <li><router-link to="/payments">Payments</router-link></li>
      </ul>
    </nav>
  </template>
  
  <script>
  export default {
    name: 'NavBar'
  };
  </script>
  
  <style scoped>
  nav {
    background-color: #42b983;
    padding: 10px;
  }
  
  ul {
    list-style-type: none;
    padding: 0;
  }
  
  li {
    display: inline;
    margin-right: 10px;
  }
  
  a {
    color: white;
    text-decoration: none;
  }
  
  a:hover {
    text-decoration: underline;
  }
  </style>
  