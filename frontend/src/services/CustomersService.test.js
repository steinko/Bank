import  {getCustomers} from './CustomersService'
import { rest } from 'msw'
import { setupServer } from 'msw/node'
const server = setupServer(
 
   rest.get('https://localhost:9000/customers', (req,res,ctx) => {
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