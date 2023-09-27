document.addEventListener('DOMContentLoaded', () => {
  const registerBtn = document.getElementById('registerBtn');
  const passwordField = document.getElementById('loginUserPassword');
  const confirmPasswordField = document.getElementById('loginUserPassword2');

  registerBtn.addEventListener('click', (e) => {
    e.preventDefault();

    const username = document.getElementById('loginUserName').value;
    const password = passwordField.value;
    const confirmPassword = confirmPasswordField.value;

    if (password !== confirmPassword) {
      alert('Passwords do not match. Please try again.');
      return;
    }

    const user = {
      username: username,
      password: password,
    };

    axios
      .post('http://localhost:8080/api/register', user) /
      .then((response) => {
        console.log('User registered successfully', response.data);
      })
      .catch((error) => {
        console.error('Registration failed', error);
      });
  });
});