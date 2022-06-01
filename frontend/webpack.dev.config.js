const webPackConfig = require("./webpack.config")
const { merge } = require('webpack-merge')


module.exports = merge(webPackConfig , {
	 
  mode: 'development',
  devtool: 'inline-source-map',

  devServer: {
   static: ',/server-build'
  
  },

})