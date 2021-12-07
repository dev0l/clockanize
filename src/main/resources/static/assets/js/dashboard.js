$(document).ready(function () {

  let hL = $('#project-card').height();
  let hR = $('.col-right').height();

  if (hL > hR) {
    let cH = hL - hR;
    $('.col-right').height(cH + hR);
  } else if (hL < hR) {
    let sH = hR - hL;
    $('#project-card').height(sH + hL);
  }

  $('table #edit-button').on('click', function (event) {
    event.preventDefault();

    let href = $(this).attr('href')

    $.get(href, function (project, status) {
      // $('#edit-id').val(project.id);
      // $('#edit-project').val(project.projectProject.id);
      // $('#edit-employee').val(project.projectEmployee.id);
      // $('#edit-start-time').val(project.startTime);
      // $('#edit-end-time').val(project.endTime);
    });
    $('#editModal').modal('toggle');
  });

  $('.table #details-button').on('click', function (event) {
    event.preventDefault();
    let href = $(this).attr('href');
    $.get(href, function (project, status) {
      $('#details-id').val(project.id);
      $('#details-description').val(project.description);
      $('#details-details').val(project.details);
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
