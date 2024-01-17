// Function to add a new course using data from input fields
function addCourse() {
    // Get values from input fields
    const courseId = document.getElementById('CourseId').value;
    const courseName = document.getElementById('CourseName').value;
    const teacher = document.getElementById('Teacher').value;

    // Check if any of the required fields are empty
    if (!courseId || !courseName || !teacher) {
        // Display an alert if any field is empty
        alert('Please provide a valid Course ID, Course Name, and Teacher.');
        return;
    }

    // Fetch API endpoint for adding a new course
    fetch('http://localhost:8080/courses', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json',
        },
        // Convert data to JSON format and send it in the request body
        body: JSON.stringify({
            courseID: courseId,
            name: courseName,
            teacher: teacher,
        }),
    })
    .then(response => {
        // Check if the response is successful
        if (response.ok) {
            console.log('Course Added.'); // Log success message
        } else {
            console.log('Failed to add course.'); // Log failure message
        }
    })
    .catch(error => console.error('Error updating courses:', error)); // Log any errors during the fetch operation
}
