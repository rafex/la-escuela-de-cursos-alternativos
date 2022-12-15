const express = require('express');
const app = express();
const swaggerUi = require('swagger-ui-express');
const swaggerDocument = require('./build/bundle-api.json');

app.use('/', swaggerUi.serve, swaggerUi.setup(swaggerDocument));
app.listen(8000, () => {
  console.log("server listening on port 8000!");
});
