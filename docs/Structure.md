InSight/
├── CMakeLists.txt                     # Główny plik budujący projekt
│
├── shared/                            # Warstwa logiki i interfejsów
│   ├── Common/
│   │   └── Message.h                  # Wspólne typy, struktury, logika danych
│   │
│   ├── UI/
│   │   ├── UiInterface.h              # Abstrakcyjny interfejs GUI
│   │   └── UiFactory.h                # Fabryka GUI (np. Qt, SDL, none)
│   │
│   ├── Compute/
│   │   ├── ComputeEngine.h            # Interfejs dla komponentu obliczeniowego (GPU)
│   │   └── ComputeFactory.h           # Fabryka Compute (np. CUDA, OpenCL)
│   │
│   └── Interlink/
│       ├── Interlink.h                # Abstrakcyjny interfejs komunikacyjny
│       ├── TcpLink.cpp/.h
│       ├── CameraLink.cpp/.h
│       ├── I2CLink.cpp/.h
│       └── InterlinkFactory.h
│
├── platform/                          # Implementacje zależne od SPRZĘTU
│   ├── rpi5/
│   │   ├── UiImpl_QtLite.cpp          # GUI na RPi5
│   │   ├── CameraLink_RPi.cpp
│   │   └── I2CLink.cpp
│   │
│   ├── jetson/
│   │   ├── ComputeImpl_Jetson.cu      # CUDA compute Jetson
│   │   └── UiImpl_Qt.cpp              # GUI Qt (np. Xavier NX z ekranem)
│   │
│   └── ubuntu_x86/
│       ├── ComputeImpl_Desktop.cpp    # CUDA/OpenCL na PC
│       └── UiImpl_Qt.cpp              # Qt GUI na desktop
│
├── entity/                            # KONKRETNE URZĄDZENIA (sprzęt + zachowanie)
│   ├── alan/
│   │   ├── main.cpp                   # Robot jeżdżący (RPi5, UDP, brak compute)
│   │   ├── CMakeLists.txt
│   │   └── config_path: ../../config/rpi5_robot.json
│   │
│   ├── neuron/
│   │   ├── main.cpp                 
│   │   ├── CMakeLists.txt
│   │   └── config_path: ../../config/jetson_drone.json
│   │
│   └── dash/
│       ├── main.cpp                 
│       ├── CMakeLists.txt
│       └── config_path: ../../config/desktop_pad.json
│
├── config/                            # Pliki konfiguracyjne RUNTIME i BUILD
│   ├── rpi5_alan.json               
│   ├── ubuntu_x86_dash.json              
│   └── devices.yaml                   # (opcjonalnie) mapa do użycia w CMake/CI
│
└── build/                             # Tworzony przez `cmake ..`

