$(document).ready(function () {

  $('table #edit-button').on('click', function (event) {
    event.preventDefault();

    let href = $(this).attr('href')

    $.get(href, function (educationStatus, status) {
      $('#edit-id').val(educationStatus.id);
      $('#edit-description').val(educationStatus.description);
      $('#edit-details').val(educationStatus.details);
    });
    $('#editModal').modal('toggle');
  });

  $('.table #details-button').on('click', function (event) {
    event.preventDefault();
    let href = $(this).attr('href');
    $.get(href, function (educationStatus, status) {
      $('#details-id').val(educationStatus.id);
      $('#details-description').val(educationStatus.description);
      $('#details-details').val(educationStatus.details);
      $('#createdByDetails').val(educationStatus.createdBy);
      $('#createdDateDetails').val(educationStatus.createdDate.substr(0,19).replace("T", " "));
      $('#lastModifiedByDetails').val(educationStatus.lastModifiedBy);
      $('#lastModifiedDateDetails').val(educationStatus.lastModifiedDate.substr(0,19).replace("T", " "));
    });
    $('#detailsModal').modal('toggle');
  });

  $('table #delete-button').on('click', function (event) {
    event.preventDefault();
    let href = $(this).attr('href')
    $('#delete-education-status-button').attr('href', href)
    $('#deleteModal').modal('toggle');
  });

});
