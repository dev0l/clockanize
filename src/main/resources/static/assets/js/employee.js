$(document).ready(function () {

  $('table #edit-button').on('click', function (event) {
    event.preventDefault();

    let href = $(this).attr('href')

    $.get(href, function (employee, status) {
      $('#edit-username').val(employee.username);
      $('#edit-id').val(employee.id);
      $('#edit-title').val(employee.title);
      $('#edit-initials').val(employee.initials);
      $('#edit-firstname').val(employee.firstname);
      $('#edit-lastname').val(employee.lastname);
      $('#edit-othername').val(employee.othername);
      $('#edit-address').val(employee.address);
      $('#edit-city').val(employee.city);
      let dob = employee.dateOfBirth.substr(0, 10);
      $('#edit-dob').val(dob);
      let hireDate = employee.hireDate.substr(0, 10);
      $('#edit-hire-date').val(hireDate);
      $('#edit-phone').val(employee.phone);
      // $('#edit-mobile').val(employee.mobile);
      $('#edit-email').val(employee.email);
      $('#edit-job-title').val(employee.jobTitle);
      $('#edit-employee-type').val(employee.employeeType.id);
      $('#edit-employee-status').val(employee.employeeStatus);
      $('#edit-image').val(employee.photo);
    });
    $('#editModal').modal('toggle');
  });

  $('.table #details-button').on('click', function (event) {
    event.preventDefault();
    let href = $(this).attr('href');
    $.get(href, function (employee, status) {
      $('#details-id').val(employee.id);
      $('#details-description').val(employee.description);
      $('#details-details').val(employee.details);
      $('#lastModifiedByDetails').val(employee.lastModifiedBy);
      $('#lastModifiedDateDetails').val(employee.lastModifiedDate.substr(0,19).replace("T", " "));
    });
    $('#detailsModal').modal('toggle');
  });

  $('table #delete-button').on('click', function (event) {
    event.preventDefault();
    let href = $(this).attr('href')
    $('#delete-employee-button').attr('href', href)
    $('#deleteModal').modal('toggle');
  });

  $('.table #photoButton').on('click', function (event) {
    event.preventDefault();
    let href = $(this).attr('href');
    $('#photoModal #employeePhoto').attr('src', href);
    $('#photoModal').modal('toggle');
  });

  // $('#uploadButton').on('click',function(event){
  // 	let href = $(this).attr('href');

  // 	$.post(href, function(data, status){
  // 		console.log(data);
  // 	});
  // });

});
