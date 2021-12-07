$(document).ready(function () {

  $('table #edit-button').on('click', function (event) {
    event.preventDefault();

    let href = $(this).attr('href')

    $.get(href, function (timeCard, status) {
      $('#edit-id').val(timeCard.id);
      $('#edit-project').val(timeCard.timeCardProject.id);
      $('#edit-educator').val(timeCard.timeCardProject.educator.id);
      $('#edit-report-date').val(timeCard.reportDate);
      // $('#edit-edit-day-of-week').val(timeCard.reportDate);
      $('#edit-start-time').val(timeCard.startTime);
      $('#edit-end-time').val(timeCard.endTime);
      $('#edit-details').val(timeCard.details);
    });
    $('#editModal').modal('toggle');
  });

  $('.table #details-button').on('click', function (event) {
    event.preventDefault();
    let href = $(this).attr('href');
    $.get(href, function (timeCard, status) {
      $('#details-id').val(timeCard.id);
      $('#details-name').val(timeCard.name);
      $('#details-description').val(timeCard.description);
      $('#createdByDetails').val(timeCard.createdBy);
      $('#createdDateDetails').val(timeCard.createdDate.substr(0, 19).replace("T", " "));
      $('#lastModifiedByDetails').val(timeCard.lastModifiedBy);
      $('#lastModifiedDateDetails').val(timeCard.lastModifiedDate.substr(0, 19).replace("T", " "));
    });
    $('#detailsModal').modal('toggle');
  });

  $('table #delete-button').on('click', function (event) {
    event.preventDefault();
    let href = $(this).attr('href')
    $('#delete-timeCard-button').attr('href', href)
    $('#deleteModal').modal('toggle');
  });

});
