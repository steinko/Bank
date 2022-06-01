import {backendUrl} from './BackendUrl'

it('should return backend url', async () => {
	
	 const aBackendUrl = 'http://localhost:3000'
	 process.env.BACKEND_URL = aBackendUrl 
     const actual = backendUrl()
     console.info(actual)
     expect(actual).toBe(aBackendUrl)
     
})


xit('should return error message', async () => {
	 process.env.BACKEND_URL = undefined
     expect(backendUrl()).toBe("enviroment variable BACKEND_URL not defined")

})


    
  