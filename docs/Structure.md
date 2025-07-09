ModularPlatform/
├── CMakeLists.txt                  # Główny plik CMake – zarządza platformą i urządzeniem
│
├── shared/                         # Interfejsy i logika współdzielona
│   ├── Common/
│   │   └── Message.h               # Struktury danych, np. do IPC
│   │
│   ├── UI/
│   │   ├── UiInterface.h           # Abstrakcyjny interfejs GUI
│   │   └── UiFactory.h             # Fabryka do tworzenia GUI
│   │
│   ├── Compute/
│   │   ├── ComputeEngine.h         # Abstrakcyjny interfejs compute
│   │   └── ComputeFactory.h        # Fabryka do tworzenia obliczeń
│   │
│   └── Interlink/
│       ├── Interlink.h             # Abstrakcyjny interfejs komunikacji
│       ├── TcpLink.cpp/.h
│       ├── CameraLink.cpp/.h
│       ├── I2CLink.cpp/.h
│       └── InterlinkFactory.h
│
├── platform/                       # Specyficzne implementacje sprzętowe
│   ├── rpi5/
│   │   ├── UiImpl_QtLite.cpp       # GUI na RPi5
│   │   ├── CameraLink_RPi.cpp
│   │   └── I2CLink.cpp
│   │
│   ├── jetson/
│   │   ├── ComputeImpl_Jetson.cu   # CUDA compute
│   │   └── UiImpl_Qt.cpp           # GUI Qt
│   │
│   └── desktop/
│       ├── ComputeImpl_Desktop.cpp # CUDA lub OpenCL
│       └── UiImpl_Qt.cpp
│
├── devices/                        # Urządzenia logiczne (różne role/procesy)
│   ├── robot_gui/
│   │   ├── main.cpp                # np. GUI + interlink TCP
│   │   └── CMakeLists.txt
│   │
│   ├── camera_node/
│   │   ├── main.cpp                # np. kamera + UDP interlink
│   │   └── CMakeLists.txt
│   │
│   └── sensor_hub/
│       ├── main.cpp                # np. I2C + TCP
│       └── CMakeLists.txt
│
├── communication/                 # Broker/interlink process
│   ├── main.cpp
│   ├── LinkFactory.h
│   └── CMakeLists.txt
│
├── compute/                       # Oddzielny proces compute (np. jako worker)
│   ├── main.cpp
│   └── CMakeLists.txt
│
├── ui/                            # Starter GUI (jeśli niezależne od device)
│   ├── main.cpp
│   └── CMakeLists.txt
│
├── config/                        # Konfiguracje uruchomieniowe
│   ├── rpi5_robot.json
│   ├── jetson_node.json
│   ├── desktop_debug.json
│   └── device_defs.yaml
│
└── build/                         # Wygenerowany przez CMake

