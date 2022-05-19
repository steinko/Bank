// src/mocks/browser.js
import { setupWorker, rest } from 'msw'
// This configures a Service Worker with the given request handlers.
export const worker = setupWorker(rest.get('https://localhost:9000/customers', (req,res,ctx) => {
		return  res ( 
			               ctx.status(200,'Customers returned'),
		                   ctx.json( 
			                           [
				                           {personId:26076144574,name:"Stein Korsveien"},
                                           {personId:26076144554,name:"Oddmund Korsveien"}
                                        ]
                                      
                                    )
                        )
		 }
    )
)