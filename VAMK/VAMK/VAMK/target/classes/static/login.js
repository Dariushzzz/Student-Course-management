// Wait for the DOM content to be fully loaded before executing the script
document.addEventListener('DOMContentLoaded', function () {
    // Get the login form element
    const loginForm = document.getElementById('loginForm');

    // Add an event listener to the login form to handle form submission
    loginForm.addEventListener('submit', function (event) {
        // Prevent the default form submission behavior
        event.preventDefault();

        // Get the input fields for username and password
        const inputUsername = document.getElementById('username');
        const inputPassword = document.getElementById('password');

        // Create an object to store the entered credentials
        const credentials = {
            username: inputUsername.value,
            password: inputPassword.value
        };

        // Fetch API endpoint for user authentication
        fetch('/login', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json',
            },
            // Convert the credentials object to JSON format and send it in the request body
            body: JSON.stringify(credentials),
        })
        .then(response => {
            // Check if the response is successful
            if (response.ok) {
                // Set a flag in sessionStorage to indicate authentication
                sessionStorage.setItem('authenticated', 'true');
                // Redirect the user to the Admin.html page
                window.location.href = '/Admin.html';
            } else {
                console.error('Login failed'); // Log an error message if authentication fails
            }
        })
        .catch(error => console.error('Error during login:', error)); // Log any errors during the fetch operation
    });
});
