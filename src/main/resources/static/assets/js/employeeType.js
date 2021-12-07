$(document).ready(function () {

  $('table #edit-button').on('click', function (event) {
    event.preventDefault();

    let href = $(this).attr('href')

    $.get(href, function (employeeType, status) {
      $('#edit-id').val(employeeType.id);
      $('#edit-description').val(employeeType.description);
      $('#edit-details').val(employeeType.details);
    });
    $('#editModal').modal('toggle');
  });

  $('.table #details-button').on('click', function (event) {
    event.preventDefault();
    let href = $(this).attr('href');
    $.get(href, function (employeeType, status) {
      $('#details-id').val(employeeType.id);
      $('#details-description').val(employeeType.description);
      $('#details-details').val(employeeType.details);
      $('#createdByDetails').val(employeeType.createdBy);
      $('#createdDateDetails').val(employeeType.createdDate.substr(0,19).replace("T", " "));
      $('#lastModifiedByDetails').val(employeeType.lastModifiedBy);
      $('#lastModifiedDateDetails').val(employeeType.lastModifiedDate.substr(0,19).replace("T", " "));
    });
    $('#detailsModal').modal('toggle');
  });

  $('table #delete-button').on('click', function (event) {
    event.preventDefault();
    let href = $(this).attr('href')
    $('#delete-employee-type-button').attr('href', href)
    $('#deleteModal').modal('toggle');
  });

});
