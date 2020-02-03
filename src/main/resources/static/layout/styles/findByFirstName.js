function myFunction() {
    var input, filter, table, trs, tds, j, i;
    input = document.getElementById("myInput");
    filter = input.value.toUpperCase();
    table = document.getElementById("myTable");
    trs = table.tBodies[0].getElementsByTagName("tr");

    for (i = 0; i < trs.length; i++) {
        tds = trs[i].getElementsByTagName("td");
        trs[i].style.display = "none";
        for (j = 1; j < tds.length; j++) {
            if (tds[j].innerHTML.toUpperCase().indexOf(filter) > -1) {
                trs[i].style.display = "";
                continue;
            }
        }
    }
}