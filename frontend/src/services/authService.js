import axios from 'axios';

const API_URL = 'http://localhost:8080/api/auth';

export const signup = async (userData) => {
  return axios.post(`${API_URL}/signup`, userData);
};

export const login = async (userData) => {
  return axios.post(`${API_URL}/login`, userData);
};
