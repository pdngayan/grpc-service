package br.com.rformagio.grpc.service;

import br.com.rformagio.grpc.server.grpcserver.*;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;

import java.util.HashMap;
import java.util.Map;

@GrpcService
public class CustomerServiceImp extends CustomerServiceGrpc.CustomerServiceImplBase {

    @Override
    public void registerCustomer(CustomerRequest request, StreamObserver<CustomerResponse> responseObserver) {
        Customer customer = request.getCustomer();
        String result="";
        if(customer.getBalance() > 1000){
            result="Priority Customer";
        }else{
            result="Normal Customer";
        }

        CustomerResponse response = CustomerResponse.newBuilder()
            .setMessage(result)
            .build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

}
