function renderTable() {

  let heroes = [
      {
          "name": "Aquaman",
          "identity": "Arthur Curry",
          "base": "Amnesty Bay"
      },
      {
        "name": "Green Lantern",
        "identity": "Hal Jordan",
        "base": "Coast City"
    },
    {
        "name": "Wonder Woman",
        "identity": "Diana Prince",
        "base": "Washington D.C."
    },
    {
        "name": "Superman",
        "identity": "Clark Kent",
        "base": "Metropolis"
    },
    {
        "name": "Batman",
        "identity": "Bruce Wayne",
        "base": "Gotham City"
    },
    {
        "name": "The Flash",
        "identity": "Barry Allen",
        "base": "Central City"
    },
    {
        "name": "Cyborg",
        "identity": "Victor Stone",
        "base": "Detroit"
    }
  ]

  for (var i = 0; i < heroes.length; i++) {
    var name = heroes[i].name;
    var identity = heroes[i].identity;
    var base = heroes[i].base;
    var table = document.getElementById("heroTable");
    var row = table.insertRow(i+1);
    var cell1 = row.insertCell(0);
    var cell2 = row.insertCell(1);
    var cell3 = row.insertCell(2);
    cell1.innerHTML = name;
    cell2.innerHTML = identity;
    cell3.innerHTML = base;
  }
}

$(document).ready(renderTable());
