// src/axios.js
import axios from 'axios';

const instance = axios.create({
  baseURL: 'http://localhost:8090', // Asegúrate de usar la URL base correcta de tu API Gateway
  withCredentials: true, // Esto es necesario si tu backend está configurado para aceptar solicitudes con credenciales
  headers: {
    'Content-Type': 'application/json',
    'Accept': 'application/json'
  }
});

export default instance;
