const loginForm = document.getElementById('login-form');
const loginUsername = document.getElementById('login-username');
const loginPassword = document.getElementById('login-password');

const handleSubmit = async (e) => {
    e.preventDefault();

    const bodyObj = {
        username: loginUsername.value,
        password: loginPassword.value
    };

    try {
        const response = await axios.post('/api/login', bodyObj);

        const responseArr = response.data;

        if (response.status === 200) {
            document.cookie = `userId=${responseArr[1]}`;
            window.location.replace('home.html');
        } else {
            console.error('Login failed:', responseArr[0]);
            window.location.replace('home.html');
        }
    } catch (err) {
        console.error(err.message);
    }
};

loginForm.addEventListener("submit", handleSubmit);