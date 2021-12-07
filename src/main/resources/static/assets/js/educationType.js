$(document).ready(function () {

  $('table #edit-button').on('click', function (event) {
    event.preventDefault();

    let href = $(this).attr('href')

    $.get(href, function (educationType, status) {
      $('#edit-id').val(educationType.id);
      $('#edit-description').val(educationType.description);
      $('#edit-details').val(educationType.details);
    });
    $('#editModal').modal('toggle');
  });

  $('.table #details-button').on('click', function (event) {
    event.preventDefault();
    let href = $(this).attr('href');
    $.get(href, function (educationType, status) {
      $('#details-id').val(educationType.id);
      $('#details-description').val(educationType.description);
      $('#details-details').val(educationType.details);
      $('#createdByDetails').val(educationType.createdBy);
      $('#createdDateDetails').val(educationType.createdDate.substr(0,19).replace("T", " "));
      $('#lastModifiedByDetails').val(educationType.lastModifiedBy);
      $('#lastModifiedDateDetails').val(educationType.lastModifiedDate.substr(0,19).replace("T", " "));
    });
    $('#detailsModal').modal('toggle');
  });

  $('table #delete-button').on('click', function (event) {
    event.preventDefault();
    let href = $(this).attr('href')
    $('#delete-education-type-button').attr('href', href)
    $('#deleteModal').modal('toggle');
  });

});
