import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

public class HelloWorldGrpcClient {
    public static void main(String[] args) {
        ManagedChannel managedChannel =
                ManagedChannelBuilder.forAddress("localhost",50051).usePlaintext().build();

        HelloWorldServiceGrpc.HelloWorldServiceBlockingStub helloWorldServiceBlockingStub =
                HelloWorldServiceGrpc.newBlockingStub(managedChannel);

        Hw.HelloRequest request = Hw.HelloRequest.newBuilder().setText("Hello").build();

        Hw.HelloResponse helloResponse = helloWorldServiceBlockingStub.hello(request);

        System.out.println(helloResponse);

    }
}
