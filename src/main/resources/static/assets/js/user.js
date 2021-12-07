$(document).ready(function () {

  $('table #edit-button').on('click', function (event) {
    event.preventDefault();

    let href = $(this).attr('href')

    $.get(href, function (user, status) {
      $('#edit-id').val(user.id);
      $('#edit-firstname').val(user.firstname);
      $('#edit-lastname').val(user.lastname);
      $('#edit-lastname').val(user.othername);
      $('#edit-username').val(user.username);
      let password = user.get('password');
      $('#edit-password').val(password);
    });
    $('#editModal').modal('toggle');
  });


  $('.table #details-button').on('click', function (event) {
    event.preventDefault();
    let href = $(this).attr('href');
    $.get(href, function (user, status) {
      $('#details-id').val(user.id);
      // $('#details-description').val(user.description);
      // $('#details-details').val(user.details);
      // $('#createdByDetails').val(user.createdBy);
      // $('#createdDateDetails').val(user.createdDate.substr(0, 19).replace("T", " "));
      // $('#lastModifiedByDetails').val(user.lastModifiedBy);
      // $('#lastModifiedDateDetails').val(user.lastModifiedDate.substr(0, 19).replace("T", " "));
    });
    $('#detailsModal').modal('toggle');
  });

  $('table #delete-button').on('click', function (event) {
    event.preventDefault();

    let href = $(this).attr('href')

    $('#delete-user-button').attr('href', href)

    $('#deleteModal').modal('toggle');

  });

});
