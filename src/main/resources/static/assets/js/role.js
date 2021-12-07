$(document).ready(function () {

  $('table #edit-button').on('click', function (event) {
    event.preventDefault();

    let href = $(this).attr('href')

    $.get(href, function (role, status) {
      $('#edit-id').val(role.id);
      $('#edit-description').val(role.description);
      $('#edit-details').val(role.details);
    });
    $('#editModal').modal('toggle');
  });

  $('.table #details-button').on('click', function (event) {
    event.preventDefault();
    let href = $(this).attr('href');
    $.get(href, function (role, status) {
      $('#details-id').val(role.id);
      $('#details-description').val(role.description);
      $('#details-details').val(role.details);
      $('#createdByDetails').val(role.createdBy);
      $('#createdDateDetails').val(role.createdDate.substr(0, 19).replace("T", " "));
      $('#lastModifiedByDetails').val(role.lastModifiedBy);
      $('#lastModifiedDateDetails').val(role.lastModifiedDate.substr(0, 19).replace("T", " "));
    });
    $('#detailsModal').modal('toggle');
  });

  $('table #delete-button').on('click', function (event) {
    event.preventDefault();
    let href = $(this).attr('href')
    $('#delete-role-button').attr('href', href)
    $('#deleteModal').modal('toggle');
  });

});
