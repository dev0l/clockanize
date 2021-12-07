$(document).ready(function () {

  $('table #edit-button').on('click', function (event) {
    event.preventDefault();

    let href = $(this).attr('href')

    $.get(href, function (education, status) {

      $('#edit-id').val(education.id);
      $('#edit-name').val(education.name);
      $('#edit-description').val(education.description);
      $('#edit-course').val(education.course);
      $('#edit-education-type').val(education.educationType.id);
      $('#edit-education-status').val(education.educationStatus.id);
      $('#edit-remarks').val(education.remarks);
    });
    $('#editModal').modal('toggle');
  });

  $('.table #details-button').on('click', function (event) {
    event.preventDefault();
    let href = $(this).attr('href');
    $.get(href, function (education, status) {
      $('#details-id').val(education.id);
      $('#details-name').val(education.name);
      $('#details-description').val(education.description);
      $('#createdByDetails').val(education.createdBy);
      $('#createdDateDetails').val(education.createdDate.substr(0, 19).replace("T", " "));
      $('#lastModifiedByDetails').val(education.lastModifiedBy);
      $('#lastModifiedDateDetails').val(education.lastModifiedDate.substr(0, 19).replace("T", " "));
    });
    $('#detailsModal').modal('toggle');
  });

  $('table #delete-button').on('click', function (event) {
    event.preventDefault();

    let href = $(this).attr('href')

    $('#delete-education-button').attr('href', href)

    $('#deleteModal').modal('toggle');

  });

});