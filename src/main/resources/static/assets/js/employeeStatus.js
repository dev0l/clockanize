$(document).ready(function () {

  $('table #edit-button').on('click', function (event) {
    event.preventDefault();

    let href = $(this).attr('href')

    $.get(href, function (employeeStatus, status) {
      $('#edit-id').val(employeeStatus.id);
      $('#edit-description').val(employeeStatus.description);
      $('#edit-details').val(employeeStatus.details);
    });
    $('#editModal').modal('toggle');
  });

  $('.table #details-button').on('click', function (event) {
    event.preventDefault();
    let href = $(this).attr('href');
    $.get(href, function (employeeStatus, status) {
      $('#details-id').val(employeeStatus.id);
      $('#details-description').val(employeeStatus.description);
      $('#details-details').val(employeeStatus.details);
      $('#createdByDetails').val(employeeStatus.createdBy);
      $('#createdDateDetails').val(employeeStatus.createdDate.substr(0,19).replace("T", " "));
      $('#lastModifiedByDetails').val(employeeStatus.lastModifiedBy);
      $('#lastModifiedDateDetails').val(employeeStatus.lastModifiedDate.substr(0,19).replace("T", " "));
    });
    $('#detailsModal').modal('toggle');
  });

  $('table #delete-button').on('click', function (event) {
    event.preventDefault();
    let href = $(this).attr('href')
    $('#delete-employee-status-button').attr('href', href)
    $('#deleteModal').modal('toggle');
  });

});
