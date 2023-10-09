document.getElementById("registerBtn").addEventListener("click", function() {
  const userData = {
        username: loginUserName.value,
        password: loginUserPassword.value,
    };
  console.log("Register User has been called")

  window.location.replace('home.html');
  axios.post("/api/register", userData)
  .then(response => {
    console.log("User saved:", response.data);
  })
  .catch(error => {
    console.error("Error saving user:", error)
  })
});