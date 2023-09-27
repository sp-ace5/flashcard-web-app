const loginUser = async (user) => {
  try {
    const response = await axios.post(`${baseURL}/api/users/login`, user);
    console.log('Login successful', response.data);
    return response.data;
  } catch (error) {
    console.error('Login failed', error);
    throw error;
  }
};