$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("src/main/java/bdd/feature/Shopping.feature");
formatter.feature({
  "line": 1,
  "name": "Shopping",
  "description": "",
  "id": "shopping",
  "keyword": "Feature"
});
formatter.scenario({
  "line": 3,
  "name": "Track my budget",
  "description": "",
  "id": "shopping;track-my-budget",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 4,
  "name": "I have 100 in my wallet",
  "keyword": "Given "
});
formatter.step({
  "line": 5,
  "name": "I buy milk with 10",
  "keyword": "When "
});
formatter.step({
  "line": 6,
  "name": "I should have 90 in my wallet",
  "keyword": "Then "
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
});