var winston = require('winston');
var Elasticsearch = require('winston-elasticsearch');
  var instance = null
  var logger
  var esTransportOpts = {
	  level: 'info' ,
  clientOpts: { node: 'http://localhost:9200' },
  index:'bank-presenter',
  level: 'info' }

class Logger { 

   constructor() {
        logger = winston.createLogger({
           transports: [
               new Elasticsearch(esTransportOpts)
          ]
       })
    }

	 static getLogger() { 
     if (instance == null)  { 
        instance =  new Logger()
      }
     return logger
   }
 } 
export default Logger