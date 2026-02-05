export function logInfo(message) {
  if (import.meta.env.DEV) {
    console.log("[INFO]:", message);
  }
}

export function logError(error) {
  console.error("[ERROR]:", error);
}