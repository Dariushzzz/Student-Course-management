// Wait for the DOM content to be fully loaded before executing the script
document.addEventListener('DOMContentLoaded', function () {
    // Fetch students data from the server
    fetch('/students')
        .then(response => response.json())
        .then(students => {
            // Get the table element for displaying student data
            const studentTable = document.getElementById('studentTable');

            // Iterate through each student and add a row to the table
            students.forEach(student => {
                const row = studentTable.insertRow();
                row.insertCell(0).textContent = student.studentID;
                row.insertCell(1).textContent = student.firstname;
                row.insertCell(2).textContent = student.lastname;
                row.insertCell(3).textContent = student.email;
            });
        });

    // Fetch courses data from the server
    fetch('/courses')
        .then(response => response.json())
        .then(courses => {
            // Get the table element for displaying course data
            const courseTable = document.getElementById('courseTable');

            // Iterate through each course and add a row to the table
            courses.forEach(course => {
                const row = courseTable.insertRow();
                row.insertCell(0).textContent = course.courseID;
                row.insertCell(1).textContent = course.name;
                row.insertCell(2).textContent = course.teacher;
            });
        });
});
