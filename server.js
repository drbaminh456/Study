const express = require('express');
const app = express();
const path = require('path');
app.use(express.static('./dist/angular-tour-of-heroes'));
app.get('/*', function(req, res) {
  res.sendFile(path.join('./dist/angular-tour-of-heroes/index.html'));
});
app.listen(process.env.PORT || 8080);