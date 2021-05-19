package com.example.demo.client;

import com.example.demo.HelloRequest;
import com.example.demo.HelloResponse;
import com.example.demo.HelloServiceGrpc;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

public class GrpcClient {
    public static void main(String[] args) throws InterruptedException {
        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 8080)
                .usePlaintext()
                .build();

        HelloServiceGrpc.HelloServiceBlockingStub stub
                = HelloServiceGrpc.newBlockingStub(channel);

        HelloResponse helloResponse = stub.hello(HelloRequest.newBuilder()
                .setFirstName("Sarvagy")
                .setLastName("Agarwal")
                .build());

        System.out.println("Response received from server:\n" + helloResponse);

        channel.shutdown();
    }
}
