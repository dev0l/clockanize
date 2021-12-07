$(document).ready(function () {

  $('table #edit-button').on('click', function (event) {
    event.preventDefault();

    let href = $(this).attr('href')

    $.get(href, function (jobTitle, status) {
      $('#edit-id').val(jobTitle.id);
      $('#edit-description').val(jobTitle.description);
      $('#edit-details').val(jobTitle.details);
    });
    $('#editModal').modal('toggle');
  });

  $('.table #details-button').on('click', function (event) {
    event.preventDefault();
    let href = $(this).attr('href');
    $.get(href, function (jobTitle, status) {
      $('#details-id').val(jobTitle.id);
      $('#details-description').val(jobTitle.description);
      $('#details-details').val(jobTitle.details);
      $('#createdByDetails').val(jobTitle.createdBy);
      $('#createdDateDetails').val(jobTitle.createdDate.substr(0,19).replace("T", " "));
      $('#lastModifiedByDetails').val(jobTitle.lastModifiedBy);
      $('#lastModifiedDateDetails').val(jobTitle.lastModifiedDate.substr(0,19).replace("T", " "));
    });
    $('#detailsModal').modal('toggle');
  });

  $('table #delete-button').on('click', function (event) {
    event.preventDefault();
    let href = $(this).attr('href')
    $('#delete-job-title-button').attr('href', href)
    $('#deleteModal').modal('toggle');
  });

});
