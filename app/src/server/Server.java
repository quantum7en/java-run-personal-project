package server;

import com.sun.net.httpserver.HttpContext;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.net.BindException;
import java.net.InetSocketAddress;
import java.util.concurrent.Executor;

public class Server {
    private static HttpServer httpServerInstance;
    private Server(){}
    public static HttpServer getHttpServerInstance() throws IOException{
        if(httpServerInstance == null){
            httpServerInstance = new HttpServer() {
                /**
                 * Binds a currently unbound HttpServer to the given address and port number.
                 * A maximum backlog can also be specified. This is the maximum number of
                 * queued incoming connections to allow on the listening socket.
                 * Queued TCP connections exceeding this limit may be rejected by the TCP implementation.
                 *
                 * @param addr    the address to listen on
                 * @param backlog the socket backlog. If this value is less than or equal to zero,
                 *                then a system default value is used.
                 * @throws BindException        if the server cannot bind to the requested address or if the server
                 *                              is already bound.
                 * @throws NullPointerException if addr is <code>null</code>
                 */
                @Override
                public void bind(InetSocketAddress addr, int backlog) throws IOException {

                }

                /**
                 * Starts this server in a new background thread. The background thread
                 * inherits the priority, thread group and context class loader
                 * of the caller.
                 */
                @Override
                public void start() {

                }

                /**
                 * sets this server's {@link Executor} object. An
                 * Executor must be established before {@link #start()} is called.
                 * All HTTP requests are handled in tasks given to the executor.
                 * If this method is not called (before start()) or if it is
                 * called with a <code>null</code> Executor, then
                 * a default implementation is used, which uses the thread
                 * which was created by the {@link #start()} method.
                 *
                 * @param executor the Executor to set, or <code>null</code> for  default
                 *                 implementation
                 * @throws IllegalStateException if the server is already started
                 */
                @Override
                public void setExecutor(Executor executor) {

                }

                /**
                 * returns this server's Executor object if one was specified with
                 * {@link #setExecutor(Executor)}, or <code>null</code> if none was
                 * specified.
                 *
                 * @return the Executor established for this server or <code>null</code> if not set.
                 */
                @Override
                public Executor getExecutor() {
                    return null;
                }

                /**
                 * stops this server by closing the listening socket and disallowing
                 * any new exchanges from being processed. The method will then block
                 * until all current exchange handlers have completed or else when
                 * approximately <i>delay</i> seconds have elapsed (whichever happens
                 * sooner). Then, all open TCP connections are closed, the background
                 * thread created by start() exits, and the method returns.
                 * Once stopped, a HttpServer cannot be re-used. <p>
                 *
                 * @param delay the maximum time in seconds to wait until exchanges have finished.
                 * @throws IllegalArgumentException if delay is less than zero.
                 */
                @Override
                public void stop(int delay) {

                }

                /**
                 * Creates a HttpContext. A HttpContext represents a mapping from a
                 * URI path to a exchange handler on this HttpServer. Once created, all requests
                 * received by the server for the path will be handled by calling
                 * the given handler object. The context is identified by the path, and
                 * can later be removed from the server using this with the {@link #removeContext(String)} method.
                 * <p>
                 * The path specifies the root URI path for this context. The first character of path must be
                 * '/'. <p>
                 * The class overview describes how incoming request URIs are <a href="#mapping_description">mapped</a>
                 * to HttpContext instances.
                 *
                 * @param path    the root URI path to associate the context with
                 * @param handler the handler to invoke for incoming requests.
                 * @throws IllegalArgumentException if path is invalid, or if a context
                 *                                  already exists for this path
                 * @throws NullPointerException     if either path, or handler are <code>null</code>
                 */
                @Override
                public HttpContext createContext(String path, com.sun.net.httpserver.HttpHandler handler) {
                    return null;
                }

                /**
                 * Creates a HttpContext. A HttpContext represents a mapping from a
                 * URI path to a exchange handler on this HttpServer. Once created, all requests
                 * received by the server for the path will be handled by calling
                 * the given handler object. The context is identified by the path, and
                 * can later be removed from the server using this with the {@link #removeContext(String)} method.
                 * <p>
                 * The path specifies the root URI path for this context. The first character of path must be
                 * '/'. <p>
                 * The class overview describes how incoming request URIs are <a href="#mapping_description">mapped</a>
                 * to HttpContext instances.
                 *
                 * @param path    the root URI path to associate the context with
                 * @param handler the handler to invoke for incoming requests.
                 * @throws IllegalArgumentException if path is invalid, or if a context
                 *                                  already exists for this path
                 * @throws NullPointerException     if either path, or handler are <code>null</code>
                 */

                /**
                 * Creates a HttpContext. A HttpContext represents a mapping from a
                 * URI path to a exchange handler on this HttpServer. Once created, all requests
                 * received by the server for the path will be handled by calling
                 * the given handler object. The context is identified by the path, and
                 * can later be removed from the server using this with the {@link #removeContext(String)} method.
                 * <p>
                 * The path specifies the root URI path for this context. The first character of path must be
                 * '/'. <p>
                 * The class overview describes how incoming request URIs are <a href="#mapping_description">mapped</a>
                 * to HttpContext instances.
                 *
                 * @param path    the root URI path to associate the context with
                 * @param handler the handler to invoke for incoming requests.
                 * @throws IllegalArgumentException if path is invalid, or if a context
                 *                                  already exists for this path
                 * @throws NullPointerException     if either path, or handler are <code>null</code>
                 */

                public HttpContext createContext(String path, HttpHandler handler) {
                    return null;
                }

                /**
                 * Creates a HttpContext without initially specifying a handler. The handler must later be specified using
                 * {@link HttpContext #setHandler(HttpHandler)}.  A HttpContext represents a mapping from a
                 * URI path to an exchange handler on this HttpServer. Once created, and when
                 * the handler has been set, all requests
                 * received by the server for the path will be handled by calling
                 * the handler object. The context is identified by the path, and
                 * can later be removed from the server using this with the {@link #removeContext(String)} method.
                 * <p>
                 * The path specifies the root URI path for this context. The first character of path must be
                 * '/'. <p>
                 * The class overview describes how incoming request URIs are <a href="#mapping_description">mapped</a>
                 * to HttpContext instances.
                 *
                 * @param path the root URI path to associate the context with
                 * @throws IllegalArgumentException if path is invalid, or if a context
                 *                                  already exists for this path
                 * @throws NullPointerException     if path is <code>null</code>
                 */
                @Override
                public HttpContext createContext(String path) {
                    return null;
                }

                /**
                 * Removes the context identified by the given path from the server.
                 * Removing a context does not affect exchanges currently being processed
                 * but prevents new ones from being accepted.
                 *
                 * @param path the path of the handler to remove
                 * @throws IllegalArgumentException if no handler corresponding to this
                 *                                  path exists.
                 * @throws NullPointerException     if path is <code>null</code>
                 */
                @Override
                public void removeContext(String path) throws IllegalArgumentException {

                }

                /**
                 * Removes the given context from the server.
                 * Removing a context does not affect exchanges currently being processed
                 * but prevents new ones from being accepted.
                 *
                 * @param context the context to remove
                 * @throws NullPointerException if context is <code>null</code>
                 */
                @Override
                public void removeContext(HttpContext context) {

                }

                /**
                 * returns the address this server is listening on
                 *
                 * @return the address/port number the server is listening on
                 */
                @Override
                public InetSocketAddress getAddress() {
                    return null;
                }
            };
        }
        return httpServerInstance;
    }

    public static class HttpHandler{}


}
