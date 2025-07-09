ModularPlatform/
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
│   └── desktop/
│       ├── ComputeImpl_Desktop.cpp    # CUDA/OpenCL na PC
│       └── UiImpl_Qt.cpp              # Qt GUI na desktop
│
├── entity/                            # KONKRETNE URZĄDZENIA (sprzęt + zachowanie)
│   ├── robot_vehicle/
│   │   ├── main.cpp                   # Robot jeżdżący (RPi5, UDP, brak compute)
│   │   ├── CMakeLists.txt
│   │   └── config_path: ../../config/rpi5_robot.json
│   │
│   ├── drone/
│   │   ├── main.cpp                   # Dron z Jetsonem (compute + interlink)
│   │   ├── CMakeLists.txt
│   │   └── config_path: ../../config/jetson_drone.json
│   │
│   └── pilot_pad/
│       ├── main.cpp                   # Pilot/operator (GUI + komunikacja TCP)
│       ├── CMakeLists.txt
│       └── config_path: ../../config/desktop_pad.json
│
├── config/                            # Pliki konfiguracyjne RUNTIME i BUILD
│   ├── rpi5_robot.json                # Konfiguracja dla robota jeżdżącego
│   ├── jetson_drone.json              # Konfiguracja dla drona
│   ├── desktop_pad.json               # Konfiguracja dla pilota
│   └── devices.yaml                   # (opcjonalnie) mapa do użycia w CMake/CI
│
└── build/                             # Tworzony przez `cmake ..`

