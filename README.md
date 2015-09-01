# remote-eval

A demo Hoplon project with Castra designed to show clojure's RPC capabilities.

## Dependencies

- java 1.7+
- [boot (yes, even if it says it's a legacy version, that's the one you want)][1]
- [leiningen][2]

## Usage

1. Start the auto-compiler. In a terminal:

    ```bash
    $ boot dev-debug
    ```

2. Go to [http://localhost:8000][3] in your browser. You should see "Hello,
Hoplon and Castra!" with random numbers that are generated on the server and
transmited to the client. But you should change that to what you want.

3. You're already done.

## License

Copyright © 2015, **Your Name Goes Here**

[1]: https://github.com/tailrecursion/boot
[2]: https://github.com/technomancy/leiningen
[3]: http://localhost:8000
