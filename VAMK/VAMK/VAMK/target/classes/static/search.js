// Wait for the DOM content to be fully loaded before executing the script
document.addEventListener('DOMContentLoaded', function () {
    // Get containers for displaying student and course details
    const studentDetails = document.getElementById('studentDetails');
    const courseDetails = document.getElementById('courseDetails');

    // Function to fetch and display student details based on the entered student ID
    function fetchStudentDetails() {
        // Get the input field for student ID
        const studentIdInput = document.getElementById('studentIdInput');
        const studentId = studentIdInput.value;

        // Fetch student details from the server based on the entered student ID
        fetch(`http://localhost:8080/students/${studentId}`)
            .then(response => response.json())
            .then(student => {
                // Check if a student is found
                if (student) {
                    // Display student details
                    const detailsHtml = `
                        <p>ID: ${student.studentID}</p>
                        <p>First Name: ${student.firstname}</p>
                        <p>Last Name: ${student.lastname}</p>
                        <p>Email: ${student.email}</p>
                    `;
                    studentDetails.innerHTML = detailsHtml;
                } else {
                    // Display message if student not found
                    studentDetails.innerHTML = '<p>Student not found</p>';
                }
            })
            .catch(error => console.error('Error fetching student details:', error));
    }

    // Function to fetch and display course details based on the entered course ID
    function fetchCourseDetails() {
        // Get the input field for course ID
        const courseIdInput = document.getElementById('courseIdInput');
        const courseId = courseIdInput.value;

        // Fetch course details from the server based on the entered course ID
        fetch(`http://localhost:8080/courses/${courseId}`)
            .then(response => response.json())
            .then(course => {
                // Check if a course is found
                if (course) {
                    // Display course details
                    const detailsHtml = `
                        <p>ID: ${course.courseID}</p>
                        <p> Course: ${course.name}</p>
                        <p> Teacher: ${course.teacher}</p>
                    `;
                    courseDetails.innerHTML = detailsHtml;
                } else {
                    // Display message if course not found
                    courseDetails.innerHTML = '<p>Course not found</p>';
                }
            })
            .catch(error => console.error('Error fetching course details:', error));
    }

    // Add event listeners to buttons for fetching student and course details
    document.querySelector('#studentIdButton').addEventListener('click', fetchStudentDetails);
    document.querySelector('#courseIdButton').addEventListener('click', fetchCourseDetails);
});
