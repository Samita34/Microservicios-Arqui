import { createRouter, createWebHistory } from 'vue-router';
import HomePage from '../components/HomePage.vue';
import ProductsPage from '../components/ProductsPage.vue';
import OrdersPage from '../components/OrdersPage.vue';
//mport PaymentList from '../components/PaymentList.vue';
import RegisterPage from '../components/RegisterPage.vue';
import LoginPage from '../components/LoginPage.vue';
const routes = [
  { path: "/", redirect: "/login"},
  { path: '/login', name: 'LoginPage', component: LoginPage },
  { path: '/home', name: 'HomePage', component: HomePage },
  { path: '/products', name: 'ProductsPage', component: ProductsPage },
  { path: '/orders', name: 'OrdersPage', component: OrdersPage },
  { path: '/register', name: 'RegisterPage', component: RegisterPage },
  //{ path: '/payments', name: 'PaymentList', component: PaymentList },
];

const router = createRouter({
  history: createWebHistory(process.env.BASE_URL),
  routes,
});

export default router;
