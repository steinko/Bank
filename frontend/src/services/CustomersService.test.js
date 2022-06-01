import  {getCustomers} from './CustomersService'
import { rest } from 'msw'
import { setupServer } from 'msw/node'
import {backendUrl} from './BackendUrl'


	
const server = setupServer(
 
   rest.get(backendUrl(), (req,res,ctx) => {
		return  res ( 
			               ctx.status(200,'Customers returned'),
		                   ctx.json( 
			                           [{personId:26076144574, name:"Stein Korsveien"}, {personId:26076144554, name:"Oddmund Korsveien"}]
                                      
                                    )
                        )
		 }
    )
)

it('should return customers', async () => {
	
	 process.env.BACKEND_URL = 'http://localhost:9000)'
	 server.listen()
     
	 const customers = await getCustomers()
     console.info(customers)
     expect([
	           {
	             personId:26076144574,
                 name:"Stein Korsveien"
               },
               { 
	             personId:26076144554,
                 name:"Oddmund Korsveien"
                }
             ])
          .toMatchObject(customers)

      server.close()
  })