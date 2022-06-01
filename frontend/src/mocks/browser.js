// src/mocks/browser.js
import { setupWorker, rest } from 'msw'
import { backendUrl } from '../services/BackendUrl'

export const worker = setupWorker(rest.get(backendUrl(), (req,res,ctx) => {
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