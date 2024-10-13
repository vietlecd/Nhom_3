package com.javaweb.connect;

import java.util.List;

public interface IKlineWebSocketService {

    void connectToKlineWebSocket(List<String> streams);

    //void closeWebSocket();
}
