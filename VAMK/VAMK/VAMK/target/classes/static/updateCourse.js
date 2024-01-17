// Function to update a course using data from input fields
function updateCourse() {
    // Get values from input fields
    const courseId = document.getElementById('CourseId').value;
    const courseName = document.getElementById('CourseName').value;
    const teacher = document.getElementById('Teacher').value;

    // Check if the course ID is provided
    if (!courseId) {
        alert('Please provide the course ID to update a course.');
        return;
    }

    // Fetch API endpoint for updating a specific course by ID
    fetch(`http://localhost:8080/courses/${courseId}`, {
        method: 'PUT',
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
            console.log('Course updated.'); // Log success message
        } else {
            console.log('Failed to update course.'); // Log failure message
        }
    })
    .catch(error => console.error('Error updating courses:', error)); // Log any errors during the fetch operation
}
