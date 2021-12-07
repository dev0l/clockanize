$(document).ready(function () {

  let od = $('#overdue-check').html();
  if (od) {
    $('#overdue-check').css("color", "red");
  }

  $('table #edit-button').on('click', function (event) {
    event.preventDefault();

    let href = $(this).attr('href')

    $.get(href, function (project, status) {
      $('#edit-id').val(project.id);
      $('#edit-name').val(project.name);
      $('#edit-client').val(project.client_id);
      $('#edit-location').val(project.location_id);
      $('#edit-description').val(project.description);
      $('#edit-educations').val(project.education_id);
      $('#edit-educators').val(project.educator_id);
      $('#edit-owner').val(project.owner_id);
      $('#edit-start-date').val(project.startDate);
      $('#edit-end-date').val(project.endDate);
      $('#edit-education-time').val(project.educationTime);
      $('#edit-planned-time').val(project.plannedTime);
      $('#edit-overdue').val(project.overdue);
    });
    $('#editModal').modal('toggle');
  });

  $('.table #details-button').on('click', function (event) {
    event.preventDefault();
    let href = $(this).attr('href');
    $.get(href, function (project, status) {
      $('#details-id').val(project.id);
      $('#details-name').val(project.name);
      $('#details-client').val(project.client_id);
      $('#details-location').val(project.location_id);
      $('#details-description').val(project.description);
      $('#details-educations').val(project.education_id);
      $('#details-educators').val(project.educator_id);
      $('#details-owner').val(project.owner_id);
      $('#details-education-time').val(project.educationTime);
      $('#details-planned-time').val(project.plannedTime);
      $('#details-start-date').val(project.startDate);
      $('#details-end-date').val(project.endDate);
      $('#details-overdue').val(project.overdue);
      $('#createdByDetails').val(project.createdBy);
      $('#createdDateDetails').val(project.createdDate.substr(0, 19).replace("T", " "));
      $('#lastModifiedByDetails').val(project.lastModifiedBy);
      $('#lastModifiedDateDetails').val(project.lastModifiedDate.substr(0, 19).replace("T", " "));
    });
    $('#detailsModal').modal('toggle');
  });

  $('table #delete-button').on('click', function (event) {
    event.preventDefault();

    let href = $(this).attr('href')

    $('#delete-project-button').attr('href', href)

    $('#deleteModal').modal('toggle');

  });

});