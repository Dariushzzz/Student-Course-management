// Function to update a student using data from input fields
function updateStudent() {
    // Get values from input fields
    const studentId = document.getElementById('StudentId').value;
    const firstname = document.getElementById('firstname').value;
    const lastname = document.getElementById('lastname').value;
    const email = document.getElementById('email').value;

    // Create an object with the updated student data
    const studentData = {
        firstname: firstname,
        lastname: lastname,
        email: email
    };

    // Fetch API endpoint for updating a specific student by ID
    fetch(`http://localhost:8080/students/${studentId}`, {
        method: 'PUT',
        headers: {
            'Content-Type': 'application/json',
        },
        // Convert the student data to JSON format and send it in the request body
        body: JSON.stringify(studentData),
    })
    .then(response => {
        // Check if the response is successful (status code 2xx)
        if (response.ok) {
            console.log('Student updated successfully'); // Log success message
        } else {
            console.log('Failed to update student'); // Log failure message
        }
    })
    .catch(error => console.error('Error during request:', error)); // Log any errors during the fetch operation
}
