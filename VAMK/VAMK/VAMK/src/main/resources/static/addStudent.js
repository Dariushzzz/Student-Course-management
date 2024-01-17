// Function to add a new student using data from input fields
function addStudent() {
    // Get values from input fields
    const studentId = document.getElementById('StudentId').value;
    const firstname = document.getElementById('firstname').value;
    const lastname = document.getElementById('lastname').value;
    const email = document.getElementById('email').value;

    // Check if any of the required fields are empty
    if (!studentId || !firstname || !lastname || !email) {
        console.error('Please fill all fields.'); // Log an error message
        return;
    }

    // Create a new student object with the collected data
    const newStudent = {
        studentID: studentId,
        firstname: firstname,
        lastname: lastname,
        email: email
    };

    // Fetch API endpoint for adding a new student
    fetch('http://localhost:8080/students', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json',
        },
        // Convert the new student object to JSON format and send it in the request body
        body: JSON.stringify(newStudent),
    })
    .then(response => {
        // Check if the response is successful
        if (response.ok) {
            console.log('Student added successfully!'); // Log success message
        } else {
            console.error('Failed to add student:', response.statusText); // Log failure message
        }
    })
    .catch(error => console.error('Error during adding student:', error)); // Log any errors during the fetch operation
}
